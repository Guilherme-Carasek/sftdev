<?php
include_once 'scripts/check.php';
include_once 'scripts/save.php';

$name = "";
$familyName = "";
$email = "";
$confirmEmail = "";
$phone = "";
$password = "";
$confirmPassword = "";
$birthday = "";
$picture = "";
$errors = array();
$registration_successful = null;

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
	$name = trim($_POST["name"]);
	$familyName = trim($_POST["familyName"]);
	$errors["name"] = checkName($name, 3);
	$errors["familyName"] = checkName($familyName, 2);

	$email = strtolower(trim($_POST["email"]));
	$confirmEmail = strtolower(trim($_POST["confirmEmail"]));
	$errors["email"] = checkEmail($email);
	$errors["confirmEmail"] = checkConfirm($email, $confirmEmail);

	$phone = trim($_POST["phone"]);
	$errors["phone"] = checkPhone($phone);

	$birthday = trim($_POST["birthday"]);
	$errors["birthday"] = checkBirthday($birthday);

	$password = trim($_POST["password"]);
	$confirmPassword = trim($_POST["confirmPassword"]);
	$errors["password"] = checkPassword($password);
	$errors["confirmPassword"] = checkConfirm($password, $confirmPassword);

	$uniqueError = checkUnique($email, $phone);
	if ($uniqueError) {
		$errors["email"] = $uniqueError;
		$errors["phone"] = $uniqueError;
	}

	$errors["picture"] = checkPicture($_FILES["picture"]);

	if (!array_filter($errors)) {
		$data = array(
			"name" => $name,
			"familyName" => $familyName,
			"email" => $email,
			"phone" => $phone,
			"birthday" => $birthday
		);

		saveData($data, $_FILES["picture"]);

		$name = "";
		$familyName = "";
		$email = "";
		$confirmEmail = "";
		$phone = "";
		$password = "";
		$confirmPassword = "";
		$birthday = "";
		$picture = "";

		$registration_successful = true;
	} else {
		$registration_successful = false;
	}

	if ($registration_successful !== null) {
		include 'pages/alert.php';
		$registration_successful = null;
	}
}
?>

<form id="form1" method="post" enctype="multipart/form-data" autocomplete="off">
	<div class="row">
		<div class="form-group col">
			<label for="name">Name:</label>
			<input type="text" class="form-control" name="name" id="name" autocomplete="off" placeholder="Your Name..." value="<?php echo $name ?>">
			<?php if (isset($errors["name"])) {
				echo '<span style="color: red;">' . $errors["name"] . '</span>';
			} ?>
		</div>
		<div class="form-group col">
			<label for="familyName">Family Name:</label>
			<input type="text" class="form-control" name="familyName" id="familyName" autocomplete="off" placeholder="Your Family Name..." value="<?php echo $familyName ?>">
			<?php if (isset($errors["familyName"])) {
				echo '<span style="color: red;">' . $errors["familyName"] . '</span>';
			} ?>
		</div>
	</div>
	<div class="row">
		<div class="form-group col">
			<label for="email">Email:</label>
			<input type="email" class="form-control" name="email" id="email" autocomplete="off" placeholder="Your Email..." value="<?php echo $email ?>">
			<?php if (isset($errors["email"])) {
				echo '<span style="color: red;">' . $errors["email"] . '</span>';
			} ?>
		</div>
		<div class="form-group col">
			<label for="confirmEmail">Confirm Email:</label>
			<input type="email" class="form-control" name="confirmEmail" id="confirmEmail" autocomplete="off" placeholder="Confirm Email..." value="<?php echo $email ?>">
			<?php if (isset($errors["confirmEmail"])) {
				echo '<span style="color: red;">' . $errors["confirmEmail"] . '</span>';
			} ?>
		</div>
	</div>
	<div class="row">
		<div class="form-group col">
			<label for="phone">Phone:</label>
			<input type="text" class="form-control" name="phone" id="phone" autocomplete="off" placeholder="Your Phone..." value="<?php echo $phone ?>">
			<?php if (isset($errors["phone"])) {
				echo '<span style="color: red;">' . $errors["phone"] . '</span>';
			} ?>
		</div>
		<div class="form-group col">
			<label for="birthday">Birthday:</label>
			<input type="date" class="form-control" name="birthday" id="birthday" autocomplete="off" value="<?php echo $birthday ?>" max="<?php echo date('Y-m-d'); ?>">
			<?php if (isset($errors["birthday"])) {
				echo '<span style="color: red;">' . $errors["birthday"] . '</span>';
			} ?>
		</div>
	</div>
	<div class="row">
		<div class="form-group col">
			<label for="password">Password:</label>
			<input type="password" class="form-control" name="password" id="password" autocomplete="off" placeholder="Your Password..." value="<?php echo $password ?>">
			<?php if (isset($errors["password"])) {
				echo '<span style="color: red;">' . $errors["password"] . '</span>';
			} ?>
		</div>
		<div class="form-group col">
			<label for="confirmPassword">Confirm Password:</label>
			<input type="password" class="form-control" name="confirmPassword" id="confirmPassword" autocomplete="off" placeholder="Confirm Password..." value="<?php echo $password ?>">
			<?php if (isset($errors["confirmPassword"])) {
				echo '<span style="color: red;">' . $errors["confirmPassword"] . '</span>';
			} ?>
		</div>
		<div class="form-group mt-2">
			<label for="picture">Profile Picture:</label>
			<input type="file" class="form-control-file" id="picture" name="picture">
			<?php if (isset($errors["picture"])) {
				echo '<span style="color: red;">' . $errors["picture"] . '</span>';
			} ?>
		</div>
		<button type="submit" class="btn btn-success mt-4 w-10 d-flex align-items-center justify-content-center"><span class="material-symbols-outlined">
				save
			</span>Submit</button>
</form>
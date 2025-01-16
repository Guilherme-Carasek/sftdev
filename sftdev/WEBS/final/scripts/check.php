<?php
include 'load.php';

function checkName($name, $len)
{
	if ($name == "") {
		return 'Name is required!';
	} elseif (strlen($name) < $len) {
		return 'Name is too short!';
	}
	return null;
}

function checkBirthday($date)
{
	if ($date == "") {
		return 'Birthday is required!';
	} elseif (!checkdate(substr($date, 5, 2), substr($date, 8, 2), substr($date, 0, 4))) {
		return 'Invalid Date!';
	} elseif ($date > date('Y-m-d', strtotime('-18 years'))) {
		return 'You must be at least 18 years old!';
	} elseif ($date < date('Y-m-d', strtotime('-120 years'))) {
		return 'You must be older than 120 years!';
	}
	return null;
}

function checkPassword($password)
{
	if ($password == "") {
		return 'Password is required!';
	} elseif (strlen($password) < 8) {
		return 'Password must be at least 8 characters long!';
	} elseif (!(preg_match('/[A-Z]/', $password)
		&& preg_match('/[a-z]/', $password)
		&& preg_match('/[\W_]/', $password)
		&& preg_match('/\d/', $password))) {
		return 'Password must contain at least one upper case, one lower case, one digit and a special character!';
	} elseif (!preg_match('/^[\x20-\x7E]+$/', $password) || preg_match('/\s/', $password)) {
		return 'Password must not contain invalid characters!';
	}
	return null;
}

function checkEmail($email)
{
	if ($email == "") {
		return 'Email is required!';
	} elseif (!filter_var($email, FILTER_VALIDATE_EMAIL)) {
		return 'Email is invalid!';
	}
	return null;
}

function checkConfirm($field1, $field2)
{
	if ($field1 != $field2) {
		return 'Fields do not match!';
	}
	return null;
}

function checkPhone($phone)
{
	if ($phone == "") {
		return 'Phone Number is required!';
	} elseif (is_numeric($phone) && (strlen($phone) == 9 || strlen($phone) == 12) || strlen($phone) == 14) {
		if (strlen($phone) == 9) {
			$temp = substr($phone, 0, 1);
		} elseif (strlen($phone) == 12) {
			$temp = substr($phone, 0, 4);
		} elseif (strlen($phone) == 14) {
			$temp = substr($phone, 0, 6);
		}
		if (!($temp == '9' || $temp == '3519' || $temp == '003519')) {
			return 'Invalid Area Code!';
		}
	} else {
		return 'Phone Number is invalid!';
	}
	return null;
}

function checkUnique($email, $phone)
{
	$data = loadData();
	foreach ($data as $entry) {
		if ($entry['email'] == $email && checkUniquePhone($entry['phone'], $phone))
			return 'Email or Phone must be unique!';
	}
	return null;
}

function checkUniquePhone($phone1, $phone2)
{
	$last9Phone1 = substr($phone1, -9);
	$last9Phone2 = substr($phone2, -9);
	return $last9Phone1 === $last9Phone2;
}

function checkPicture($file)
{
	if (isset($file) && $file["error"] == 0) {
		$allowedExtensions = ["jpg", "jpeg", "png", "gif"];
		$extension = pathinfo($file["name"], PATHINFO_EXTENSION);
		if (!in_array($extension, $allowedExtensions)) {
			return "Invalid file type. Only JPG, JPEG, PNG and GIF types are allowed";
		}
	} else {
		return "Profile Picture is required";
	}
	return null;
}

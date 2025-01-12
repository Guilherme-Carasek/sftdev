<!--
Primeiro nome
Apelidos
email
confirmação email
data nascimento
telemovel
-->

<?php

function validateDate($date, $format = 'Y-m-d H:i:s')
{
    $d = DateTime::createFromFormat($format, $date);
    return $d && $d->format($format) == $date;
}

$errors = array();
$firstname = ""; $lastname = ""; $email = ""; $confirmEmail = ""; $password = ""; $passwordConfirm = ""; $birthDate = ""; $phoneNumber = "";

if($_POST != null){
    print_r($_POST);
    $firstname = $_POST["firstname"];
    if(empty($_POST["firstname"])){
        $errors["firstname"] = "O campo é de preenchimento obrigatório";
    }
    else if(strlen(trim($_POST["firstname"])) < 3){
    $errors["firstname"] = "O campo deve ter pelo menos 3 caracteres";
    }

    $lastname = $_POST["lastname"];
    if(empty($_POST["lastname"])){
        $errors["lastname"] = "O campo é de preenchimento obrigatório";
    }
    else if(strlen(trim($_POST["lastname"])) < 3){
    $errors["lastname"] = "O campo deve ter pelo menos 3 caracteres";
    }

    $email = $_POST["InputEmail"];
    if (empty($_POST["InputEmail"])){
        $errors["email"] = "O campo é de preenchimento obrigatório";
    }
    else if (!filter_var($email, FILTER_VALIDATE_EMAIL)) {
        $errors["email"] = "Email em formato inválido";
    }

    $confirmEmail = $_POST["InputEmailconfirm"];
    if (empty($_POST["InputEmailconfirm"])){
        $errors["confirmEmail"] = "O campo é de preenchimento obrigatório";
    }
    else if (!filter_var($confirmEmail, FILTER_VALIDATE_EMAIL)) {
        $errors["confirmEmail"] = "Email em formato inválido";
    }
    else if ($email != $confirmEmail){
        $errors["confirmEmail"] = "Os campos de email devem ser iguais";
    }

    $password = $_POST["InputPassword"];
    $passwordPattern = '/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d).{8,}$/';
    if (empty($_POST["InputPassword"])){
        $errors["password"] = "O campo é de preenchimento obrigatório";
    }
    else if (!preg_match($passwordPattern, $password)){
        $errors["password"] = "Password no formato inválido";
    }

    $passwordConfirm = $_POST["InputPasswordConfirm"];
    if (empty($_POST["InputPasswordConfirm"])){
        $errors["passwordConfirm"] = "O campo é de preenchimento obrigatório";
    }
    else if (!preg_match($passwordPattern, $passwordConfirm)) {
        $errors["passwordConfirm"] = "Password no formato inválido";
    }
    else if ($password != $passwordConfirm){
        $errors["passwordConfirm"] = "Os campos de password devem ser iguais";
    }

    $birthDate = $_POST["InputDate"];
    $birthDate = str_replace("/","-",$birthDate);
    $birthArr = explode('-',$birthDate);
    if (empty($_POST["InputDate"])){
        $errors["birthDate"] = "O campo é de preenchimento obrigatório";
    }
    if (count($birthArr) != 3){
        $errors["birthDate"] = "Data no formato inválido(a data deve ser separada por '/' ou '-')";
    }
    else if (!checkdate($birthArr[1],$birthArr[2],$birthArr[0])){
        $errors["birthDate"] = "Data inválida";
    }
    else if (time() - strtotime($birthDate) < 568024668){
        $errors["birthDate"] = "Deve ter pelo menos 18 anos";
    }
    else if (time() - strtotime($birthDate) > 3786912000){
        $errors["birthDate"] = "A idade máxima é 120 anos";
    }

    $phoneNumber = $_POST["phoneNumber"];
    $phoneArr = str_split($phoneNumber);
    if (empty($_POST["phoneNumber"])){
        $errors["phoneNumber"] = "O campo é de preenchimento obrigatório";
    }
    else if (count($phoneArr) == 9){
        if($phoneArr[0] != 9){
            $errors["phoneNumber"] = "O número deve começar com 9";
        }
    }
    else if (count($phoneArr) == 12){
        if($phoneArr[3] != 9){
            $errors["phoneNumber"] = "O número deve começar com 9";
        }
    }
    else if (count($phoneArr) == 14){
        if($phoneArr[5] != 9){
            $errors["phoneNumber"] = "O número deve começar com 9";
        }
    }
    else {
        $errors["phoneNumber"] = "O número deve ter 9, 12 ou 14 dígitos";
    }





}

?>


<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<div class="container px-5">
<form method="POST">
    <div class="mb-3">
        <label for="firstname" class="form-label">Primeiro nome</label>
        <input type="text" name="firstname" class="form-control" value="<?php echo $firstname; ?>" id="firstname">
        <?php if(isset($errors["firstname"])){ echo $errors["firstname"]; } ?>
      </div>
  <div class="mb-3">
      <label for="lastname" class="form-label">Apelido</label>
      <input type="text" name="lastname" class="form-control" value="<?php echo $lastname; ?>" id="lastname">
      <?php if(isset($errors["lastname"])){ echo $errors["lastname"]; } ?>
    </div>
  <div class="mb-3">
    <label for="InputEmail" class="form-label">Endereço de Email</label>
    <input type="text" name="InputEmail" class="form-control" value="<?php echo $email; ?>" id="InputEmail">
    <?php if(isset($errors["email"])){ echo $errors["email"]; } ?>
  </div>
  <div class="mb-3">
      <label for="InputEmailconfirm" class="form-label">Confirme seu endereço de Email</label>
      <input type="text" name="InputEmailconfirm" class="form-control" value="<?php echo $confirmEmail; ?>" id="InputEmailconfirm">
      <?php if(isset($errors["confirmEmail"])){ echo $errors["confirmEmail"]; } ?>
    </div>
  <div class="mb-3">
    <label for="InputPassword" class="form-label">Password</label>
    <input type="text" name="InputPassword" class="form-control" value="<?php echo $password; ?>" id="InputPassword">
    <?php if (isset($errors["password"])){ echo $errors["password"]; } ?>
  </div>
  <div class="mb-3">
      <label for="InputPasswordConfirm" class="form-label">Confirme sua Password</label>
      <input type="text" name="InputPasswordConfirm" class="form-control" value="<?php echo $passwordConfirm; ?>" id="InputPasswordConfirm">
      <?php if (isset($errors["passwordConfirm"])){ echo $errors["passwordConfirm"]; } ?>
    </div>
    <div class="mb-3">
        <label for="inputDate" class="form-label">Data de nascimento</label>
        <input type="date" name="InputDate" class="form-control" value="<?php echo $birthDate; ?>" id="InputDate">
        <?php if (isset($errors["birthDate"])){ echo $errors["birthDate"]; } ?>
    </div>
    <div class="mb-3">
        <label for="phoneNumber" class="form-label">Número de telemóvel</label>
        <input type="text" name="phoneNumber" class="form-control" value="<?php echo $phoneNumber; ?>" id="phoneNumber">
        <?php if (isset($errors["phoneNumber"])){ echo $errors["phoneNumber"]; } ?>
    </div>
  <button type="submit" class="btn btn-primary">Enviar</button>
</form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
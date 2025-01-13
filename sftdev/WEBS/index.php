<?php 
	$jsonContents = file_get_contents("jsonFiles/userData.json");
	$contentArray = json_decode($jsonContents, true);
?>





<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Tabela</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
  
  </head>
  <body class="bg-dark-subtle">
    <main>
		<div class="container py-5">
			<table class="table table-striped">
			  <thead>
				<tr>
				  <th scope="col">Nome</th>
				  <th scope="col">Apelido</th>
				  <th scope="col">Email</th>
				  <th scope="col">Data de nascimento</th>
				  <th scope="col">Número de telefone</th>
				  <th scope="col">Foto de perfil</th>
				</tr>
			  </thead>
			  <tbody>				
				<?php   
					foreach($contentArray as $user) {
						echo("<tr>
							<th scope=\"row\">" . $user["firstname"] . "</th>
							<td>" . $user["lastname"] . "</td>
							<td>" . $user["InputEmail"] . "</td>
							<td>" . $user["InputDate"] . "</td>
							<td>" . $user["phoneNumber"] . "</td>
							<td>" . $user["profilePicture"] . "</td>
						");
					}	
				?>
			  </tbody>
			</table> 
		</div>
    </main>
	
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
 
  </body>
</html>
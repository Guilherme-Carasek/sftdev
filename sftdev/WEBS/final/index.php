<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Pedro Bento</title>
	<link
		href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
		rel="stylesheet"
		integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
		crossorigin="anonymous" />
	<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined" />
	<link rel="stylesheet" href="css/style.css" />
</head>

<body>
	<?php
	//if page is set abre a pagina pedida, se não, abre o formulario
	$page = isset($_GET['page']) ? $_GET['page'] : 'form';
	?>
	<div class="container-fluid">
		<ul class="nav nav-tabs nav-fill">
			<li class="nav-item">
				<a class="nav-link <?php echo $page == 'form' ? 'active' : ''; ?>" href="?page=form">Form</a>
			</li>
			<li class="nav-item">
				<a class="nav-link <?php echo $page == 'table' ? 'active' : ''; ?>" href="?page=table">Table</a>
			</li>
		</ul>
		<div class="container-fluid d-flex flex-column justify-content-center" id="content">
			<?php
			if ($page == 'form') {
				include 'pages/form.php';
			} elseif ($page == 'table') {
				include 'pages/table.php';
			}
			?>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>

</html>
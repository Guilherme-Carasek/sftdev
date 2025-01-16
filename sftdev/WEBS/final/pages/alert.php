<div class="alert <?php echo $registration_successful ? 'alert-success' : 'alert-danger'; ?> alert-dismissible fade show" role="alert">
	<?php echo $registration_successful ? 'User registered successfully!' : 'There were errors in your form submission!'; ?>
	<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
</div>

<script>
	setTimeout(function() {
		var alertElement = document.querySelector('.alert');
		if (alertElement) {
			var alert = new bootstrap.Alert(alertElement);
			alert.close();
		}
	}, 5000);
</script>
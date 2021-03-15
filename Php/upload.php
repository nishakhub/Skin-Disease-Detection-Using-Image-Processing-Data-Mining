<?php

if(isset($_FILES["uploaded_file"]["name"])){

	$name = $_FILES["uploaded_file"]["name"];
	$tmp_name = $_FILES['uploaded_file']['tmp_name'];
	$error = $_FILES['uploaded_file']['error'];
	
	
	if(!empty($name)){
		
		$location = './assets/';
		if(!is_dir($location))
			mkdir($location);
		$imagecount = count(glob('C:\xampp\htdocs\upload\assets\*.jpg'));
		$imagecount = $imagecount + 1;
		$new_extension = 'jpg';
		if(move_uploaded_file($tmp_name, $location.$imagecount. '.' . $new_extension))
			echo "Uploaded";
			
	}
	else
		echo "Please choose a file";

	}

?>
<?php
	
	$host = 'localhost';
	$user = 'root';
	$pwd = '';
	$db = 'skinclinic';

	$conn = mysqli_connect($host, $user, $pwd, $db);

	if(!$conn){
		die("Error in connection ". mysqli_connect_error());
	}

	$response =  array();

	$sql_query = "select output from result ORDER BY id DESC LIMIT 1";
	$result =  mysqli_query($conn, $sql_query);

	if(mysqli_num_rows($result) > 0){
		$response['success'] = 1;
		$a = array();
		while ($row = mysqli_fetch_assoc($result)) {

			# code...
			array_push($a, $row);
		}
		$response['a'] = $a;
	}
	else
	{
		$response['success'] = 0;
		$response['message'] = 'No data';
	}
	echo json_encode($response);
	mysqli_close($conn);
?>

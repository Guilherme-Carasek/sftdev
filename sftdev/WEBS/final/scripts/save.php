<?php
include_once 'load.php';

function saveData($data, $file)
{
	$path = 'data/data.json';
	$users = loadData();

	$timestamp = date("Y-m-d_H-i-s");
	$extension = pathinfo($file["name"], PATHINFO_EXTENSION);
	$filename = $data['name'] . $data['familyName'] . "_" . $timestamp . "." . $extension;
	$picture = "img/" . $filename;
	move_uploaded_file($file["tmp_name"], $picture);

	$data['picture'] = $picture;
	$users[] = $data;

	file_put_contents($path, json_encode($users, JSON_PRETTY_PRINT));
}

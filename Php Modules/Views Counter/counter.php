<?php

	// Connecting to the database
	$link = mysqli_connect("Host_Name", "DB_Name", "Password", "Password");
    if($link === false)
	{
        die("ERROR: Could not connect. " . mysqli_connect_error());
    }
	
	//echo "hi";
	$sql = "SELECT * FROM `view-counter` WHERE No='1'";
	$result = $link->query($sql);
	$row = $result->fetch_assoc();
	$count = $row['total-views'];
	$count++;
	$sql = "UPDATE `view-counter` SET `total-views`='$count'";
	$link->query($sql);
	
?>
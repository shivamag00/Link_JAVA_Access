<?php

	// Connecting to the database
	$link = mysqli_connect("sql111.epizy.com", "epiz_25434353", "JdgDDluCoT1z", "epiz_25434353_iiitstudy");
    if($link === false)
	{
        die("ERROR: Could not connect. " . mysqli_connect_error());
    }
	
	echo "Total Views :  ";
	$sql = "SELECT * FROM `view-counter` WHERE No='1'";
	$result = $link->query($sql);
	$row = $result->fetch_assoc();
	$count = $row['total-views'];
	echo $count;
	
?>
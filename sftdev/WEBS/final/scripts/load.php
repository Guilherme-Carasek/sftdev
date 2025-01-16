<?php
function loadData()
{
    $path = 'data/data.json';
    if (file_exists($path)) {
        $data = file_get_contents($path);
        $json = json_decode($data, true);
        return $json;
    } else {
        return array();
    }
}

if (isset($_GET['load'])) {
    $data = loadData();
    echo json_encode($data);
}

<?php
include_once 'load.php';

function deleteEntry($email, $phone)
{
    $path = 'data/data.json';
    $data = loadData();
    $newData = array();

    foreach ($data as $entry) {
        if ($entry['email'] !== $email || !checkUniquePhone($entry['phone'], $phone)) {
            $newData[] = $entry;
        } else {
            if (file_exists($entry['picture'])) {
                unlink($entry['picture']);
            }
        }
    }

    file_put_contents($path, json_encode($newData, JSON_PRETTY_PRINT));
}

function deleteEntryByIndex($index)
{
    $path = 'data/data.json';
    $data = loadData();

    if (isset($data[$index])) {
        $entry = $data[$index];
        if (file_exists($entry['picture'])) {
            unlink($entry['picture']);
        }
        unset($data[$index]);
        $data = array_values($data);
        file_put_contents($path, json_encode($data, JSON_PRETTY_PRINT));
    }
}

if ($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_POST['email']) && isset($_POST['phone'])) {
    deleteEntry($_POST['email'], $_POST['phone']);
    exit();
}
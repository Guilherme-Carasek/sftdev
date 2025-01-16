<?php
include_once 'scripts/load.php';
include_once 'scripts/delete.php';

$data = loadData();

if (!isset($data)) {
    $data = [];
}

if (isset($_GET['linha'])) {
    $index = intval($_GET['linha']);
    if (isset($_GET['action']) && $_GET['action'] === 'delete') {
        deleteEntryByIndex($index);
        echo "<script>alert('Entry deleted successfully.'); window.location.href = 'index.php?page=table';</script>";
        exit();
    } else {
        $data = isset($data[$index]) ? [$data[$index]] : [];
    }
}
?>

<?php if (!empty($data)): ?>
    <?php foreach ($data as $index => $entry): ?>
        <div class="card m-2">
            <div class="card-body d-flex justify-content-end">
                <table class="table table-bordered">
                    <tr>
                        <th scope="row">Name</th>
                        <td><?php echo htmlspecialchars($entry['name']); ?></td>
                    </tr>
                    <tr>
                        <th scope="row">Family Name</th>
                        <td><?php echo htmlspecialchars($entry['familyName']); ?></td>
                    </tr>
                    <tr>
                        <th scope="row">Email</th>
                        <td><?php echo htmlspecialchars($entry['email']); ?></td>
                    </tr>
                    <tr>
                        <th scope="row">Phone</th>
                        <td><?php echo htmlspecialchars($entry['phone']); ?></td>
                    </tr>
                    <tr>
                        <th scope="row">Birthday</th>
                        <td><?php echo htmlspecialchars($entry['birthday']); ?></td>
                    </tr>
                    <tr>
                        <th scope="row">Picture</th>
                        <td><img src="<?php echo htmlspecialchars($entry['picture']); ?>" width="200" alt="Profile Picture of <?php echo htmlspecialchars($entry['name']) . ' ' . htmlspecialchars($entry['familyName']) ?>"></td>
                    </tr>
                </table>
                <form method="get" action="index.php" style="display:inline;" onsubmit="return confirm('Are you sure you want to delete this entry?');">
                    <input type="hidden" name="page" value="table">
                    <input type="hidden" name="linha" value="<?php echo $index; ?>">
                    <input type="hidden" name="action" value="delete">
                    <button type="submit" class="btn btn-danger m-1">
                        <span class="material-symbols-outlined">delete</span>Delete
                    </button>
                </form>
            </div>
        </div>
    <?php endforeach; ?>
<?php else: ?>
    <div class="card w-50 m-2">
        <div class="card-body">
            <p>No data available</p>
        </div>
    </div>
<?php endif; ?>
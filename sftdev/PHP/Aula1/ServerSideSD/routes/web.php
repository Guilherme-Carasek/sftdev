<?php


use Illuminate\Support\Facades\Route;
use App\Http\Controllers\giftController;
use App\Http\Controllers\homeController;
use App\Http\Controllers\taskController;
use App\Http\Controllers\userController;

Route::get('/', function () {
    return view('welcome');
});

Route::get('/home', [homeController::class, 'index'])->name('home');

Route::get('/users', [userController::class, 'showAllUsers'])->name('users.show');

Route::get('/user/{id}', [userController::class, 'showUser'])->name('user.show');

Route::get('/add-sara', [userController::class, 'addSara'])->name('sara.add');

Route::get('/add-users', [userController::class, 'addUsers'])->name('users.add');

Route::post('/create-user', [userController::class, 'createUser'])->name('user.create');

Route::get('/delete-user/{id}', [userController::class, 'deleteUser'])->name('user.delete');

Route::get('/all-tasks', [taskController::class, 'showAllTasks'])->name('tasks.show');

Route::get('/show-task/{id}', [taskController::class, 'taskInfo'])->name('task.show');

Route::get('/delete-task/{id}', [taskController::class, 'deleteTask'])->name('task.delete');

Route::get('/complete-task/{id}', [taskController::class, 'completeTask'])->name('task.complete');

Route::get('/add-tasks', [taskController::class, 'addTasks'])->name('tasks.add');

Route::post('/add-task', [taskController::class, 'addTask'])->name('task.add');

Route::get('/all-gifts', [giftController::class, 'showAllGifts'])->name('gifts.show');

Route::get('/show-gift/{id}', [giftController::class, 'showGift'])->name('gift.show');

Route::get('/add-gifts', [giftController::class, 'addGifts'])->name('gifts.add');

Route::post('/add-gift', [giftController::class, 'addGift'])->name('gift.add');

Route::fallback(function(){
    return view('fallback');
})->name('fallback');

Route::get('/hello/{name}', function ($name) {
    return '<h1>Hello '.$name.'</h1>';
});

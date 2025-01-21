<?php


use Illuminate\Support\Facades\Route;
use App\Http\Controllers\homeController;
use App\Http\Controllers\taskController;
use App\Http\Controllers\userController;

Route::get('/', function () {
    return view('welcome');
});

Route::get('/home', [homeController::class, 'index'])->name('home');

Route::get('/users', [userController::class, 'showAllUsers'])->name('users.show');

Route::get('/add-users', [userController::class, 'addUsers'])->name('users.add');

Route::get('/all-tasks', [taskController::class, 'showAllTasks'])->name('tasks.show');

Route::fallback(function(){
    return view('fallback');
})->name('fallback');

Route::get('/hello/{name}', function ($name) {
    return '<h1>Hello '.$name.'</h1>';
});

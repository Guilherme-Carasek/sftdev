<?php

use Illuminate\Support\Facades\Route;

Route::get('/', function () {
    return view('welcome');
});

Route::get('/home', function () {
    return view('home');
})->name('home');

Route::get('/users', function () {
    return view('users.all_users');
})->name('users.show');

Route::get('/add-users', function () {
    return view('users.add_users');
})->name('users.add');

Route::fallback(function(){
    return "<a href=".route('home')."><h1>Estás perdido volte aqui</h1></a>";
});

Route::get('/hello/{name}', function ($name) {
    return '<h1>Hello '.$name.'</h1>';
});

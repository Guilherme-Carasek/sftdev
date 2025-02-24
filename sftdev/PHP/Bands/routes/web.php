<?php

use Illuminate\Support\Facades\Route;
use App\Http\Controllers\BandController;
use App\Http\Controllers\AlbumController;

Route::get('/', function () {
    return view('welcome');
});

Route::get('/home', function () { return view('home'); })->name('home');

Route::fallback( function() { return view('fallback'); } );

// ponto extra?
Route::prefix('bands')->group(function () {

    Route::get('/', [BandController::class, 'index'])->name('bands.index');

    Route::get('/create', [BandController::class, 'create'])->name('bands.create');

    Route::post('/store', [BandController::class, 'store'])->name('bands.store');

    Route::get('/edit/{id}', [BandController::class, 'edit'])->name('bands.edit')->middleware('auth');

    Route::post('/update/{id}', [BandController::class, 'update'])->name('bands.update')->middleware('auth');

    Route::get('/delete/{id}', [BandController::class, 'destroy'])->name('bands.delete');

});

Route::prefix('albums')->group(function () {

    Route::get('/show/{id}', [AlbumController::class, 'show'])->name('albums.show');

    Route::get('/create', [AlbumController::class, 'create'])->name('albums.create');

    Route::post('/store', [AlbumController::class, 'store'])->name('albums.store');

    Route::get('/delete/{id}', [AlbumController::class, 'destroy'])->name('albums.delete');



});

Route::prefix('dashboard')->group(function() {

    Route::get('/index', function() { return view('dashboard.home_dashboard'); })->name('dashboard.home')->middleware('auth');

});




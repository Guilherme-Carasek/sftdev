<?php

use Illuminate\Support\Facades\Route;
use App\Http\Controllers\BandController;

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

});




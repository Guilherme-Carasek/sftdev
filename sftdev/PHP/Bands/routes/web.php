<?php

use Illuminate\Support\Facades\Route;
use App\Http\Controllers\BandController;

Route::get('/', function () {
    return view('welcome');
});

Route::get('/home', function () { return view('home'); })->name('home');

Route::fallback( function() { return view('fallback'); } );

Route::prefix('bands')->group(function () {

    Route::get('/', [BandController::class, 'index'])->name('bands.index');

    Route::get('/create', )


});


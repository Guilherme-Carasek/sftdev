<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\DB;

class AlbumController extends Controller
{
    /**
     * Display a listing of the resource.
     */
    public function index()
    {
        //
    }

    /**
     * Show the form for creating a new resource.
     */
    public function create()
    {
        $bands = DB::table('bands')
        ->select('name', 'id')
        ->get();

        return view('Albums.create_albums', compact('bands'));
    }

    /**
     * Store a newly created resource in storage.
     */
    public function store(Request $request)
    {
        //
    }

    /**
     * Display the specified resource.
     */
    public function show(string $id)
    {
        $albums = DB::table('bands')
        ->leftJoin('albums', 'bands.id', 'albums.band_id')
        ->where('bands.id', $id)
        ->select('bands.name as bandName', 'bands.photo as bandPhoto', 'albums.id', 'albums.name as albumName',
         'albums.release_date', 'albums.photo as albumPhoto')
        ->get();

        return view('Albums.show_albums', compact('albums'));
    }

    /**
     * Show the form for editing the specified resource.
     */
    public function edit(string $id)
    {
        //
    }

    /**
     * Update the specified resource in storage.
     */
    public function update(Request $request, string $id)
    {
        //
    }

    /**
     * Remove the specified resource from storage.
     */
    public function destroy(string $id)
    {
        //
    }
}

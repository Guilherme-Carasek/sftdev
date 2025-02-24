<?php

namespace App\Http\Controllers;

use App\Models\Album;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\DB;
use Illuminate\Support\Facades\Storage;

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
        $request->validate([
            'name'=>'required|string|min:3|max:36',
            'release_date'=>'required|date',
            'photo'=> 'image|nullable',
            'band_id'=>'required|exists:bands,id'
        ]);

        if($request->hasFile('photo')){
            $photo = Storage::putFile('albumPhotos', $request->photo);
        }

        Album::insert([
            'name'=>$request->name,
            'release_date'=>$request->release_date,
            'photo'=>$photo,
            'band_id'=>$request->band_id
        ]);

        return redirect()->route('albums.show', $request->band_id)->with('message', 'Succesfully added album to catalog');
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
        DB::table('albums')
        ->where('id', $id)
        ->delete();

        return redirect()->route('bands.index')->with('message', 'Album succesfully deleted');
    }
}

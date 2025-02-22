<?php

namespace App\Http\Controllers;

use App\Models\Band;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\DB;
use Illuminate\Support\Facades\Storage;

class BandController extends Controller
{
    /**
     * Display a listing of the resource.
     */
    public function index()
    {
        $bands = DB::table('bands')
        ->leftJoin('albums', 'bands.id', '=', 'albums.band_id')
        ->select('bands.name','bands.photo', 'bands.id', DB::raw('COUNT(albums.band_id) as numberOfAlbums'))
        ->groupBy('bands.id', 'bands.name', 'bands.photo')
        ->get();

        return view('bands.all_bands', compact('bands'));
    }

    /**
     * Show the form for creating a new resource.
     */
    public function create()
    {
        return view('bands.create_bands');
    }

    /**
     * Store a newly created resource in storage.
     */
    public function store(Request $request)
    {
        $request->validate([
            'name' => 'required|string|min:3|max:22|unique:bands,name',
            'photo' => 'image'
        ]);

        $photo= null;

        if($request->hasFile('photo')){
            $photo = Storage::putFile('bandPhotos', $request->photo);
        }

        Band::insert([
            'name' => $request->name,
            'photo' => $photo
        ]);

        return redirect()->route('bands.index')->with('message', 'Succesfully added band to the catalog');
    }

    /**
     * Display the specified resource.
     */
    public function show(string $id)
    {
        //
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

    private function getBandsFromDb(){
        //
    }
}

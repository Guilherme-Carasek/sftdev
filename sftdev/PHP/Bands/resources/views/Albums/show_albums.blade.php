{{-- {{ dd($albums) }} --}}

@extends('layouts.main_layout')

@section('title')
    {{ $albums[0]->bandName }}
@endsection

@section('content')
    <img id="bandCover" src="{{ $albums[0]->bandPhoto ? asset('storage/' . $albums[0]->bandPhoto) : asset('img/nophoto.png') }}" alt="">
    <div class="row">
        <h1>{{$albums[0]->bandName}}</h1>
    </div>

    @if ($albums[0]->id)
        albums here

    @else
        <p>No registered albums yet</p>
        <a href="">Add new album</a>
    @endif


@endsection

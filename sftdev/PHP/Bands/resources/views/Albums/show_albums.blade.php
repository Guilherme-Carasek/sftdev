{{-- {{ dd($albums) }} --}}

@extends('layouts.main_layout')

@section('title')
    {{ $albums[0]->bandName }}
@endsection

@section('content')
    @if (session('message'))
    <div class="alert alert-success">
        {{ session('message') }}
    </div>
    @endif

    <img id="bandCover" src="{{ $albums[0]->bandPhoto ? asset('storage/' . $albums[0]->bandPhoto) : asset('img/nophoto.png') }}" alt="">
    <div class="row">
        <h1>{{$albums[0]->bandName}}</h1>
    </div>

    @if ($albums[0]->id)
    <div class="row">
        @foreach ($albums as $album)
        <div class="col-12 col-md-6 col-lg-4">
            <div class="card" style="width: 18rem;">
                <img src="{{ $album->albumPhoto ? asset('storage/' . $album->albumPhoto) : asset('img/nophoto.png') }}" class="card-img-top" alt="...">
                <div class="card-body">
                <h5 class="card-title">{{ $album->albumName }}</h5>
                <p class="card-text"> {{$album->release_date}} </p>
                @auth
                    @if (Auth::user()->user_type > 0)
                        <a href=" {{ route('albums.delete'), $album->id }} " class="btn btn-primary">Delete</a>
                    @endif
                @endauth
                </div>
            </div>
        </div>
        @endforeach
    </div>
    @else
        <p>No registered albums yet</p>
        @auth
            @if (Auth::user()->user_type > 0)
                <a href=" {{ route('albums.create') }} ">Add new album</a>
            @endif
        @endauth

    @endif


@endsection

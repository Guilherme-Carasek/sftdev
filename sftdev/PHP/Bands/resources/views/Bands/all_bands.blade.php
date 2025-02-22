@extends('layouts.main_layout')

@section('title')
Bands 🎸
@endsection

{{-- {{ dd($bands) }} --}}
@section('content')

    <h1>All bands</h1>


    @foreach($bands as $band)

        <div class="card mb-3" style="max-width: 540px;">
            <div class="row g-0">
            <div class="col-md-4">
                <img id="imgBandCard" src="{{ $band->photo ? asset('storage/' . $band->photo) : asset('img/nophoto.png') }}" class="img-fluid rounded-start" alt="...">
            </div>
            <div class="col-md-8">
                <div class="card-body">
                <h5 class="card-title">{{ $band->name }}</h5>
                <p class="card-text"><a href="{{ route('albums.show', $band->id) }}"><button class="btn btn-primary">
                    @if ( $band->numberOfAlbums > 0)
                        View {{$band->numberOfAlbums}} albums
                    @else
                        View band
                    @endif
                </button></a></p>
                <p class="card-text"></p>
                </div>
            </div>
            </div>
        </div>

    @endforeach


@endsection

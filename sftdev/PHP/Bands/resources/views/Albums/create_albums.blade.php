@extends('layouts.main_layout')

@section('title')
    new album
@endsection

@section('content')

{{-- {{ dd($bands) }} --}}
<div class="container col-6">
    <h1>New album</h1>
    <form method="POST" action="{{ route('albums.store') }}" enctype="multipart/form-data">
        @csrf
        <div class="mb-3">
        <label for="inputName" class="form-label">Album name</label>
        <input type="text" class="form-control" id="inputName" name="name">
            @error('name')
                Invalid name
            @enderror

        </div>
        <div class="mb-3">
        <label for="inputReleaseDate" class="form-label">Release date</label>
        <input type="date" class="form-control" id="inputReleaseDate" name="release_date">
        @error('release_date')
                Invalid date
        @enderror
        </div>
        <div class="mb-3">
            <label for="inputPhoto" class="form-label">Album photo</label>
            <input type="file" class="form-control" id="inputPhoto" name="photo">
            @error('photo')
                Invalid photo
            @enderror
        </div>
        <div class="mb-3">
            <select class="form-select" aria-label="Default select example" name="band_id">
            <option selected>Band</option>

                @foreach ($bands as $band)
                    <option value=" {{ $band->id }} "> {{ $band->name }} </option>
                @endforeach

            </select>
            @error('band_id')
                Invalid band
            @enderror
        </div>


        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
@endsection

@extends('layouts.main_layout')

@section('title')
    edit {{ $band->name }}
@endsection

@section('content')

<h1>edit {{ $band->name }}</h1>

<form method="POST" action="{{route('bands.update')}}" enctype="multipart/form-data">
    @csrf
    <div class="mb-3">
        <label for="bandNameInput" class="form-label">Band name</label>
        <input type="text" class="form-control" id="bandNameInput" value=" {{$band->name}} " name="name" >
        @error('name')
            Invalid name
        @enderror
    </div>
    <div class="mb-3">
        <label for="bandPhotoInput" class="form-label">Band photo</label>
        <input type="file" class="form-control" id="bandPhotoInput" name="photo" accept="image/">
        @error('photo')
            Invalid photo
        @enderror
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
    </form>

@endsection

@extends('layouts.main_layout')

@section('title')
    new album
@endsection

@section('content')

<h1>New album</h1>
<form method="POST" action="{{ route('albums.store') }}" enctype="multipart/form-data">
    <div class="mb-3">
      <label for="inputName" class="form-label">Album name</label>
      <input type="text" class="form-control" id="inputName" name="name">
    </div>
    <div class="mb-3">
      <label for="inputReleaseDate" class="form-label">Release date</label>
      <input type="date" class="form-control" id="inputReleaseDate" name="release_date">
    </div>
    <div class="mb-3">
        <label for="inputPhoto" class="form-label">Album photo</label>
        <input type="file" class="form-control" id="inputPhoto" name="photo">
    </div>
    <select class="form-select" aria-label="Default select example">
        <option selected>Open this select menu</option>
        <option value="1">One</option>
        <option value="2">Two</option>
        <option value="3">Three</option>
      </select>
    <button type="submit" class="btn btn-primary">Submit</button>
  </form>

@endsection

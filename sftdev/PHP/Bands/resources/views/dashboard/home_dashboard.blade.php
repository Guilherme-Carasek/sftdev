@extends('layouts.main_layout')

@section('title')
    dashboard
@endsection

@section('content')
    <h1>
        Hello {{Auth::user()->name}} !!!!
    </h1>
@endsection

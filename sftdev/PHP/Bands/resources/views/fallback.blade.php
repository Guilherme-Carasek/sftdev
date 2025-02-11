@extends('layouts.main_layout')
@section('title')
    Lost
@endsection


@section('content')
    <h1>You are lost. <a href=" {{ route('home') }} ">Return home</a> now</h1>
@endsection

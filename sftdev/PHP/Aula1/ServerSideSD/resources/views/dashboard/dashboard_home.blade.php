@extends('layouts.main_layout')
@section('content')

@if(Auth::user()->user_type == 1)
    <div class="alert alert-success" role="alert">
        Conta de administrador
    </div>
@endif

<h1>Olá, {{ Auth::user()->name }} </h1>

@endsection

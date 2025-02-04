@extends('layouts.main_layout')
@section('content')
    @auth
        <h1>Olá {{ Auth::user()->name }}, estou em casa</h1>
    @endauth
    <h2>{{$myVar}} </h2>
    <a href="#"> <img src=" {{ asset('images/linkedinLogo.png')}} " width="30px" alt="imagem"></a>
    <ul>
        <li><a href=" {{route('users.show')}} ">Todos os utilizadores</a></li>
        <li><a href=" {{route('users.add', 0)}} ">Adicionar utilizador</a></li>
        <li><a href=" {{route('tasks.show')}} ">Ver tarefas</a></li>
        <li><a href=" {{route('gifts.show')}} ">Ver prendas</a></li>
    </ul>

@endsection



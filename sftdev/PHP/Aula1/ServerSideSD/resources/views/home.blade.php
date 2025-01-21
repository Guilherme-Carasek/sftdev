@extends('layouts.main_layout')
@section('content')

    <h1>Olá {{ $contactInfo['name'] }}, estou em casa</h1>
    <h2>{{$myVar}} </h2>
    <a href="#"> <img src=" {{ asset('images/linkedinLogo.png')}} " width="30px" alt="imagem"></a>
    <ul>
        <li><a href=" {{route('users.show')}} ">Todos os utilizadores</a></li>
        <li><a href=" {{route('users.add')}} ">Adicionar utilizador</a></li>
        <li><a href=" {{route('tasks.show')}} ">Ver tarefas</a></li>
    </ul>

@endsection



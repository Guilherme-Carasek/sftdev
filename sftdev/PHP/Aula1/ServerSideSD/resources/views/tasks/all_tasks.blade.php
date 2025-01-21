@extends('layouts.main_layout')
@section('content')

    <h1>Tarefas</h1>

    <h5>Tarefas ocupadas</h5>
    <ul>
        @foreach ($tasks as $person)
            <li>{{$person['name']}} => {{$person['task']}}</li>
        @endforeach
    </ul>

    <h5>Tarefas disponíveis</h5>
    <ul>
        @foreach ($availableTasks as $availableTask)
        <li>{{$availableTask}}</li>
        @endforeach
    </ul>

@endsection

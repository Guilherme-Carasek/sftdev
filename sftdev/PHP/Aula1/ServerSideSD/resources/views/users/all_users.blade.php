@extends('layouts.main_layout')
@section('content')


    <h1>Aqui vês todos os utilizadores</h1>
    <ul>
        <li> {{$cesaeInfo['name']}} | {{$cesaeInfo['adress']}} | {{$cesaeInfo['email']}} </li>
    </ul>
    <h5>Contactos</h5>
    <ul>
        @foreach ($allContacts as $contact)
            <li>{{$contact['id']}} | {{$contact['name']}} | {{$contact['number']}} </li>
        @endforeach
    </ul>


@endsection

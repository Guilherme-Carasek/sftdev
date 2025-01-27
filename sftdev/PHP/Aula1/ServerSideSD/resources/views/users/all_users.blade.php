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
    <table class="table">
        <thead>
          <tr>
            <th scope="col">id</th>
            <th scope="col">Nome</th>
            <th scope="col">Email</th>
            <th scope="col">Password</th>
          </tr>
        </thead>
        <tbody>
            @foreach ($allUsers as $user)
            <tr>
                <th scope="row">{{ $user->id }}</th>
                <td> {{ $user->name }} </td>
                <td> {{ $user->email }} </td>
                <td> {{ $user->password }} </td>
            </tr>
          @endforeach
        </tbody>
      </table>


@endsection

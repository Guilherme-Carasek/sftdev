@extends('layouts.main_layout')
@section('content')

    @if (session('message'))
    <div class="alert alert-success">
        {{ session('message') }}
    </div>
    @endif

    <div class="row justify-content-center">
        <div class="col-12 col-lg-6">
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
                    <th scope="col"> </th>
                </tr>
                </thead>
                <tbody>
                    @foreach ($allUsers as $user)
                    <tr>
                        <th scope="row">{{ $user->id }}</th>
                        <td> {{ $user->name }} </td>
                        <td>
                            <a href=" {{ route('user.show', $user->id) }} "><button class="btn btn-info">Ver</button></a>
                            <a href="{{route('user.delete', $user->id)}}"><button class="btn btn-danger">Apagar</button></a>
                        </td>
                    </tr>
                @endforeach
                </tbody>
            </table>
        </div>
    </div>
@endsection

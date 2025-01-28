@extends('layouts.main_layout')
@section('content')

<div class="row justify-content-center">
    <div class="col-12 col-md-6 col-lg-5">
        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">Utilizador</th>
                <th scope="col"> {{ $user[0]->name }} </th>
                <th>
                    <a href="{{route('user.delete', $user[0]->id)}}"><button class="btn btn-danger">Excluir utilizador</button></a>
                </th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <th scope="row">Email</th>
                <td> {{ $user[0]->email }} </td>
                <td></td>
            </tr>
            <tr>
                <th scope="row">Morada</th>
                <td> {{ $user[0]->adress }} </td>
                <td></td>
            </tr>

            @if(!is_null($user[0]->taskId))
            @foreach($user as $entry)
            @if(!is_null($entry->taskId))
            <tr>
                <th scope="row">Tarefa atribuída</th>
                <td> {{ $entry->taskName }} </td>
                <td>
                    <a href="#"><button class="btn btn-info">Ver</button></a>
                    <a href="#"><button class="btn btn-danger">Apagar</button></a>
                </td>
            </tr>
            @endif
            @endforeach
            @endif

            @if(!is_null($user[0]->giftId))
            @foreach($user as $entry)
            @if(!is_null($entry->giftId))
            <tr>
                <th scope="row">Prenda à receber</th>
                <td> {{ $entry->giftName }} </td>
                <td>
                    <a href=" {{route('gift.show',$entry->giftId)}} "><button class="btn btn-info">Ver</button></a>
                    <a href=" # "><button class="btn btn-danger">Apagar</button></a>
                </td>
            </tr>
            @endif
            @endforeach
            @endif
            </tbody>
        </table>
    </div>
</div>
@endsection

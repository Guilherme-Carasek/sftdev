@extends('layouts.main_layout')
@section('content')
{{-- {{dd($user, $tasks, $gifts)}} --}}
<div class="row justify-content-center">
    <div class="col-12 col-lg-7">
        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">Utilizador</th>
                <th scope="col"> {{ $user->name }} </th>
                <th>
                    <a href="{{route('user.delete', $user->id)}}"><button class="btn btn-danger">Excluir utilizador</button></a>
                </th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <th scope="row">Email</th>
                <td> {{ $user->email }} </td>
                <td></td>
            </tr>
            <tr>
                <th scope="row">Morada</th>
                <td> {{ $user->adress }} </td>
                <td></td>
            </tr>

            @if(!is_null($tasks))
            @foreach($tasks as $task)
            @if(!is_null($task->id))
            <tr>
                <th scope="row">Tarefa atribuída</th>
                <td> {{ $task->name }}
                    @if ($task->status)
                        <span style="color: green; font-size:20px"> &check; </span>
                    @else
                        <span style="color: red; font-size:20px"> &cross; </span>
                    @endif
                </td>
                <td>
                    <a href=" {{route('task.show', $task->id)}} "><button class="btn btn-info">Ver</button></a>
                    <a href="{{route('task.complete', $task->id)}}"><button class="btn btn-success"> Feita! </button></a>
                    <a href="{{route('task.delete', $task->id)}}"><button class="btn btn-danger">Eliminar</button></a>
                </td>
            </tr>
            @endif
            @endforeach
            @endif

            @if(!is_null($gifts))
            @foreach($gifts as $gift)
            @if(!is_null($gift->id))
            <tr>
                <th scope="row">Prenda à receber</th>
                <td> {{ $gift->name }} </td>
                <td>
                    <a href=" {{route('gift.show', $gift->id)}} "><button class="btn btn-info">Ver</button></a>
                    <a href=" {{route('gifts.add', $gift->id)}} "><button class="btn btn-warning">Editar</button></a>
                    <a href=" {{route('gift.delete', $gift->id)}} "><button class="btn btn-danger">Eliminar</button></a>
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

@extends('layouts.main_layout')
@section('content')

<div class="col-12 col-lg-8">
    <h1>Tarefas</h1>

    <table class="table">
        <thead>
          <tr>
            <th scope="col">#</th>
            <th scope="col">Tarefa</th>
            <th scope="col">Descrição</th>
            <th scope="col">Prazo</th>
            <th scope="col">Concluída</th>
            <th scope="col">Utilizador</th>
          </tr>
        </thead>
        <tbody>
        @foreach ($tasks as $task)

            <tr>
                <th scope="row"> {{ $task->id }} </th>
                <td> {{ $task->name }} </td>
                <td> {{ $task->description }} </td>
                <td> {{ $task->due_at }} </td>
                <td>
                    @if ( $task->status )
                        Sim
                    @else
                        Não
                    @endif
                </td>
                <td> {{ $task->userName }} </td>
                <td>
                    <a href="#"><button class="btn btn-info">Ver</button></a>
                    <a href="#"><button class="btn btn-danger">Remover</button></a>
                </td>
            </tr>

        @endforeach
        <tr>
            <th> </th>
            <td><a href=" {{route('tasks.add')}} "><button class="btn btn-success">Adicionar tarefa</button></a></td>
        </tr>
        </tbody>
    </table>
</div>
@endsection

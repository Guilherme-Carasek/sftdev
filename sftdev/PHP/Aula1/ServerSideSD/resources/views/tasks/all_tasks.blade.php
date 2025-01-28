@extends('layouts.main_layout')
@section('content')

    @if (session('message'))
        <div class="alert alert-success">
            {{ session('message') }}
        </div>
    @endif

<div class="col-12 col-lg-8">
    <h1>Tarefas</h1>

    <table class="table">
        <thead>
          <tr>
            <th scope="col">Tarefa</th>
            <th scope="col">Prazo</th>
            <th scope="col">Estado</th>
            <th scope="col">Responsável</th>
          </tr>
        </thead>
        <tbody>
        @foreach ($tasks as $task)

            <tr>
                <td> {{ $task->name }} </td>
                <td> {{ $task->due_at }} </td>
                <td>
                    @if ( $task->status )
                        <p style="color: green; font-size:20px">&check;</p>
                    @else
                        <p style="color: red; font-size:20px">&cross;</p>
                    @endif
                </td>
                <td> {{ $task->userName }} </td>
                <td>
                    <a href=" {{route('task.show', $task->id)}} "><button class="btn btn-info">Ver</button></a>
                    <a href=" {{route('task.delete', $task->id)}} "><button class="btn btn-danger">Remover</button></a>
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

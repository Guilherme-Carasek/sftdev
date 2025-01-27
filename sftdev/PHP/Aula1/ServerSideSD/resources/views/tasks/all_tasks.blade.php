@extends('layouts.main_layout')
@section('content')

    <h1>Tarefas</h1>

    <table class="table">
        <thead>
          <tr>
            <th scope="col">#</th>
            <th scope="col">Tarefa</th>
            <th scope="col">Descrição</th>
            <th scope="col">Prazo</th>
            <th scope="col">Concluída</th>
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
            </tr>

        @endforeach
        </tbody>
      </table>

@endsection

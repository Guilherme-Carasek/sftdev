@extends('layouts.main_layout')
@section('content')

{{-- {{ dd($task) }} --}}
<div class="row justify-content-center">
    <div class="col-9 col-lg-5">
        <table class="table">
            <thead>
              <tr>
                <th scope="col"> {{ $task->id }} </th>
                <th scope="col"> {{ $task->name }} </th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <th scope="row"> Descrição </th>
                <td> {{ $task->description }} </td>
              </tr>
              <tr>
                <th scope="row"> Prazo </th>
                <td> {{ $task->due_at }} </td>
              </tr>
              <tr>
                <th scope="row"> Estado </th>
                @if ($task->status)
                    <td style="color: green; font-size:30px"> &check; </td>
                @else
                    <td style="color: red; font-size:30px"> &cross; </td>
                @endif
              </tr>
              <tr>
                <th scope="row"> Responsável </th>
                <td> {{ $task->userName }} </td>
              </tr>
              <tr style="justify-content: center">
                <td> </td>
                <td colspan="2">
                    <a href="#"><button class="btn btn-warning">Editar </button></a>
                    <a href="{{route('task.complete', $task->id)}}"><button class="btn btn-success"> Feito! </button></a>
                    <a href=" {{ route('task.delete', $task->id) }} "><button class="btn btn-danger"> Eliminar </button></a>
                </td>
              </tr>
            </tbody>
        </table>
    </div>
</div>


@endsection

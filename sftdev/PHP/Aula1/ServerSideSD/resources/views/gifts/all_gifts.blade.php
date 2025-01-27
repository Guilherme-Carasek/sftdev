@extends('layouts.main_layout')
@section('content')
<h1>Prendas</h1>

<table class="table">
    <thead>
      <tr>
        <th scope="col">#</th>
        <th scope="col">Prenda</th>
        <th scope="col">Valor esperado</th>
        <th scope="col">Receberá</th>
        <th scope="col">Valor gasto</th>
        <th scope="col">Deletar</th>
      </tr>
    </thead>
    <tbody>
@foreach($gifts as $gift)
        <tr>
            <th scope="row"> {{ $gift->id }} </th>
            <td> {{ $gift->name }} </td>
            <td> {{ $gift->expectedValue }} </td>
            <td> {{ $gift->user_id }} </td>
            <td> {{ $gift->spentValue }} </td>
            <td> <button type="button" class="btn btn-danger">Deletar</button> </td>
        </tr>
@endforeach

    </tbody>
  </table>

@endsection

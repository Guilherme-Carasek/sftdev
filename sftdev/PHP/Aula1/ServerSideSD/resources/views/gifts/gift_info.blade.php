@extends('layouts.main_layout')
@section('content')

<div class="row justify-content-center">
    <div class="col-12 col-md-6 col-lg-4">
        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">Utilizador a receber</th>
                <th scope="col"> {{ $gift->userName }} </th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <th scope="row">Prenda #{{$gift->id}}</th>
                <td> {{ $gift->name }} </td>
            </tr>
            <tr>
                <th scope="row">Valor esperado</th>
                <td> {{ $gift->expectedValue }}€ </td>
            </tr>
            @if(!is_null($gift->spentValue))
            <tr>
                <th scope="row">Valor gasto</th>
                <td> {{ $gift->spentValue }}€ </td>
            </tr>

            <tr>
                <th scope="row">Diferença</th>
                <td> {{ abs( $gift->spentValue - $gift->expectedValue ) }}€ </td>
            </tr>
            @endif
            <tr>
                <th scope="row">Contactar {{ $gift->userName }} </th>
                <td> {{ $gift->email }} </td>
            </tr>
            <tr>
                <th scope="row">Morada para envio</th>
                <td> {{ $gift->adress }} </td>
            </tr>
            <tr>
                <td> </td>
                <td colspan="2">
                    <a href=" {{route('gifts.add', $gift->id)}} "><button class="btn btn-warning">Editar</button></a>
                    <a href=" {{route('gift.delete', $gift->id)}} "> <button type="button" class="btn btn-danger">Deletar</button></a>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
@endsection

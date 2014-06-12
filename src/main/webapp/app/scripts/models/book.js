Webapp.Book = DS.Model.extend({
    title: DS.attr('string'),
    isbn: DS.attr('number')
});

Webapp.BookSerializer = DS.RESTSerializer.extend({
    primaryKey: 'isbn'
});

package functional.tests

import grails.plugin.geb.ContainerGebSpec
import grails.testing.mixin.integration.Integration

@Integration(applicationClass = Application)
class AuthorControllerSpec extends ContainerGebSpec {

    void "Test list authors"() {
        when:"The home page is visited"
        go '/author/index'

        then:"The name is correct"
        title == "Author List"
    }

    void "Test save author"() {
        when:
        go "/author/create"
        $('form').name = "Stephen King"
        $('input.save').click()

        then:"The author is correct"
        title == "Show Author"
        $('li.fieldcontain div').text() == 'Stephen King'

    }
}

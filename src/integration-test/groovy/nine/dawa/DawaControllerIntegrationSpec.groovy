package nine.dawa

import grails.core.GrailsApplication
import grails.plugins.rest.client.RestBuilder
import grails.testing.mixin.integration.Integration
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpStatus
import spock.lang.Shared
import spock.lang.Specification

@Integration
class DawaControllerIntegrationSpec extends Specification {

     @Autowired
    DawaService dawaService

    @Autowired
    GrailsApplication grailsApplication

    def setup() {
        dawaService.dawaResource = Mock(DawaResource) {
            getJson(_ ) >> [
                    [kode:'1081']
            ]
        }
    }

    def cleanup() {
        dawaService.dawaResource = grailsApplication.mainContext.getBean('dawaResource')
    }

    @Shared
    RestBuilder restBuilder = new RestBuilder()

    def "test rest response"() {
        when:
            def response = dawaService.getRegioner()
        then:
            response.first().kode == '1081'
    }

}

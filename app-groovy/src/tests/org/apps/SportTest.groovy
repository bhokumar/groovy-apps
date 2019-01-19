package tests.org.apps

import groovy.mock.interceptor.MockFor
import groovy.mock.interceptor.StubFor
import org.apps.sports.services.RateService

class SportTest extends GroovyTestCase {

    def void setUp(){
        println("Set Up method called!");
    }

    def void tearDown(){
        println("Tear down method called!")
    }

    def void testSports(){
        assert 15 == 15;
    }

    def void testPlayer(){
        assert 16 == 16;
    }

    def void testSports2(){
        shouldFail(RuntimeException) {
            //assert 15 == 16;
            throw new RuntimeException();
        }
    }

    def void testStubService(){
        def service = new StubFor(RateService);
        service.demand.getInterestRateService{
            return 0.10;
        }
        service.use {
            def rateService = new RateService();
            def rate = rateService.getInterestRateService();
            assert 1 == rate*10;
        }
    }

    def void testMockService(){
        def service = new MockFor(RateService);
        service.demand.getInterestRateService{
            return 0.10;
        }
        service.use {
            def rateService = new RateService();
            def rate = rateService.getInterestRateService();
            assert 1 == rate*10;
        }
    }

}

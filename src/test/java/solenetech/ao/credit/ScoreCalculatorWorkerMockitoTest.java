package solenetech.ao.credit;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import solenetech.ao.credit.workflow.worker.CalculateScoreWorker;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ScoreCalculatorWorkerMockitoTest {
    @Mock
    private ActivatedJob job;
    private final CalculateScoreWorker worker = new CalculateScoreWorker();
    @Test
    void testCalculateScoreWithMockito (){
        Map<String, Object> variables = Map.of(
                "income", 10000.0,
                "age", 40
        );
        when(job.getVariablesAsMap()).thenReturn(variables);

        // When
        Map<String, Object> result = worker.calculateScore(job);

        // Then
        assertEquals(250.0, result.get("score"));
        verify(job, times(1)).getVariablesAsMap();
    }
}

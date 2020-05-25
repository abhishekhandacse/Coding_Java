package design_patterns.composite;

interface IComponent {
    void play();
    void setPlaybackSpeed(float speed);
    String getName();
}

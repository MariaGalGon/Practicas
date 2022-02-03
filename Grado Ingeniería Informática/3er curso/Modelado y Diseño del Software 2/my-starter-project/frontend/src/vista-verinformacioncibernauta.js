import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';

class VistaVerinformacioncibernauta extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
        			width: 100%;
        			padding: 0px;
                }
            </style>
<vaadin-vertical-layout style="width: 100%; height: 100%; align-items: flex-start; padding: var(--lumo-space-s);" id="vertical">
 <p id="info"></p>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'vista-verinformacioncibernauta';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaVerinformacioncibernauta.is, VistaVerinformacioncibernauta);

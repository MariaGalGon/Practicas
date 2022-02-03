import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-item/src/vaadin-item.js';
import '@vaadin/vaadin-list-box/src/vaadin-list-box.js';
import './vista-comentario.js';

class VistaListacomentarios extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
        			width:100%;
                }
            </style>
<vaadin-list-box id="lista_comentarios" style="width: 100%;"></vaadin-list-box>
`;
    }

    static get is() {
        return 'vista-listacomentarios';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaListacomentarios.is, VistaListacomentarios);
